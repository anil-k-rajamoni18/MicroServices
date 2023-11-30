package com.reporthub.coreapis.records;

import lombok.Builder;
import lombok.Generated;

import java.util.List;

@Generated
@Builder
public record OrgApiResponse(String uuid,
                             Demographics demographics,
                             List<JobFunction> jobFunction,
                             List<ProviderOrg> providerOrg,
                             List<NonProviderOrg> nonProviderOrg) {
    @Builder
    public record Demographics(String firstName, String lastName, String email, String phone, String phoneExt) {
    }

    @Builder
    public record JobFunction(String code, String desc, String npi) {
    }

    @Builder
    public record ProviderOrg(String id, String corpMpin, String uhcProviderId, String firstName, String lastName,
                              boolean registeredOrg, boolean updateDocDeliverySettings, boolean paa, boolean ia) {
    }
    @Builder
    public record NonProviderOrg(String irsOrgId, String corpName, boolean paa, boolean ia) {
    }
}



