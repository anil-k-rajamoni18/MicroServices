package com.reporthub.coreapis.constants;

public enum StargateEnv {
    CORE_STAGE("stage-core"),
    CORE_PROD("core");

    private String routeIdentifier;

    StargateEnv(final String routeIdentifier) {
        this.routeIdentifier = routeIdentifier;
    }
}
