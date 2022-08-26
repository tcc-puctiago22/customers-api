package br.com.gisa.customers.v1.commons.paginate;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PaginationResponse<P> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String contractNumber;
    private List<P> data;
    private Metadata metadata;

    public PaginationResponse(Page<P> page) {
        this.data = page.getContent();
        this.metadata = new Metadata(new Pagination<>(page));
    }

    public PaginationResponse(String contractNumber, Page<P> page) {
        this.contractNumber = contractNumber;
        this.data = page.getContent();
        this.metadata = new Metadata(new Pagination<>(page));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Metadata {
        private Pagination<?> pagination;
    }

    @Getter
    @Setter
    public static class Pagination<P> {
        private long offset;
        private int limit;
        private long totalRecords;
        private long returnedRecords;

        public Pagination(Page<P> page) {
            this.offset = page.getNumber();
            this.limit = page.getSize();
            this.totalRecords = page.getTotalElements();
            this.returnedRecords = page.getNumberOfElements();
        }
    }
}
