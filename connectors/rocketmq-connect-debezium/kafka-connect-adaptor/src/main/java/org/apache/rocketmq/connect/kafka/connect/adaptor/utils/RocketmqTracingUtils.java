package org.apache.rocketmq.connect.kafka.connect.adaptor.utils;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.TextMapGetter;
import org.apache.kafka.connect.source.SourceRecord;

public class RocketmqTracingUtils {
    public static void buildAndFinishSpan(RocketmqConnectSpan sourceDebeziumSpan, SourceRecord sourceRecord,
                                          ContextPropagators contextPropagators, TextMapGetter extractor) {
        Span span = buildSpan(sourceDebeziumSpan, sourceRecord, contextPropagators, extractor);
        span.end();
    }

    private static Span buildSpan(RocketmqConnectSpan sourceDebeziumSpan, SourceRecord sourceRecord, ContextPropagators contextPropagators, TextMapGetter extractor) {
        Context parentContext = contextPropagators.getTextMapPropagator().extract(Context.current(),
                sourceRecord, extractor);


    }
}
