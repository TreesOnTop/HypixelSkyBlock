package net.swofty.commons.protocol.protocols;

import net.swofty.commons.protocol.ProtocolSpecification;

import java.util.List;

public class ProtocolPingSpecification extends ProtocolSpecification {
    @Override
    public List<ProtocolEntries<?>> getServiceProtocolEntries() {
        return List.of();
    }

    @Override
    public List<ProtocolEntries<?>> getReturnedProtocolEntries() {
        return List.of();
    }

    @Override
    public String getEndpoint() {
        return "service-ping";
    }
}
