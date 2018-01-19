package com.metric;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Nir.
 */
@Component
public class SoapServiceMetric implements PublicMetrics {
    @Override
    public Collection<Metric<?>> metrics() {
        Collection<Metric<?>> result = new LinkedHashSet<>();
        result.add(new Metric<>("nir.example.number-1", 1));
        return result;
    }
}
