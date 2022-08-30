package br.com.gisa.customers.v1.commons.filter;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Getter
@Setter
@ToString
public abstract class BasicFilter {

    @Min(0)
    Integer offset;

    @Min(3)
    @Max(20)
    Integer limit;

    @NotEmpty
    Set<String> sortBy;

    @NotNull
    Sort.Direction orderBy;

    protected BasicFilter() {
        offset = 0;
        limit = 5;
        sortBy = Set.of("createdDate");
        orderBy = Sort.Direction.DESC;
    }

    public PageRequest getPageable() {
        return PageRequest.of(offset, limit, Sort.by(orderBy, sortBy.toArray(new String[0])));
    }

    /**
     * Spring will use this method to set offset
     */
    @SuppressWarnings("unused")
    public void setOffset(Integer offset) {
        if (Objects.nonNull(offset))
            this.offset = offset;
    }

    /**
     * Spring will use this method to set limit
     */
    @SuppressWarnings("unused")
    public void setLimit(Integer limit) {
        if (Objects.nonNull(limit))
            this.limit = limit;
    }

    public Set<SearchCriteria> toCriteria() {
        Set<SearchCriteria> criteria = new HashSet<>();
        for (Field field : this.getClass().getDeclaredFields())
            add(field, criteria);
        return criteria;
    }

    private void add(Field field, Set<SearchCriteria> criteria) {
        if (field.isAnnotationPresent(FilterAttribute.class)) {
            try {
                ReflectionUtils.makeAccessible(field);
                Object value = ReflectionUtils.getField(field, this);
                if (Objects.nonNull(value)) {
                    FilterAttribute annotation = field.getAnnotation(FilterAttribute.class);
                    String key = StringUtils.isEmpty(annotation.name()) ? field.getName() : annotation.name();
                    criteria.add(new SearchCriteria(key, annotation.operator(), value));
                }
            } catch (IllegalStateException e) {
                log.warn("Field '{}' is not a valid filter:: {}", field.getName(), e.getMessage());
            }
        }
    }

}
