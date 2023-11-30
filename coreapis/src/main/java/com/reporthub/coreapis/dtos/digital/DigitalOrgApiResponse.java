package com.reporthub.coreapis.dtos.digital;

import java.util.List;

public record DigitalOrgApiResponse(
        String uuid,
        Demographics demographics,
        List<JobFunction> jobFunction,
        List<ProviderOrg> providerOrg,
        List<NonProviderOrg> nonProviderOrg
) {
    public record Demographics(String firstName, String lastName, String email, String phone, String phoneExt
    ) {}

    public record JobFunction(String code, String desc, String npi
    ) {}


    public record ProviderOrg(String id, String corpMpin, String uhcProviderId, String firstName, String lastName, boolean registeredOrg, boolean paa, boolean ia
    ){}

    public record NonProviderOrg(String irsOrgId, String corpName, boolean paa, boolean ia
    ){}

}




