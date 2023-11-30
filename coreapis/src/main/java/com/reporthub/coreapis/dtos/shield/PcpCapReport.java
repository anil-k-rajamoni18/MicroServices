package com.reporthub.coreapis.dtos.shield;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PcpCapReport {
    private Meta meta;
    private List<PcpData>
            data;

    @Data
    public static class Meta {
        private Integer offset;
        private Integer limit;
        private String rosterMessage;
        private Integer totalMemberCount;
        private List<Warning> warnings;

        @Data
        public static class Warning {
            private String status;
            private String code;
            private String title;
            private String detail;
        }
    }

    @Data
    public static class PcpData {
        private String id;
        private String product;
        private String memberName;
        private String address;
        private String phone;
        private String dob;
        private String gender;
        private String effectiveDate;
    }
}
