package kr.co.automl.domain.metadata.distribution;

import kr.co.automl.domain.metadata.distribution.dto.CreateDistributionAttributes;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public class Distribution {

    private long id;

    private String downloadUrl;
    private String timeStamp;
    private AccurualPeriodicity accurualPeriodicity;
    private String spatial;
    private String timeInfo;

    @Builder
    private Distribution(String downloadUrl, String timeStamp, AccurualPeriodicity accurualPeriodicity, String spatial, String timeInfo) {
        this.downloadUrl = downloadUrl;
        this.timeStamp = timeStamp;
        this.accurualPeriodicity = accurualPeriodicity;
        this.spatial = spatial;
        this.timeInfo = timeInfo;
    }

    public static Distribution from(CreateDistributionAttributes createDistributionAttributes) {
        return Distribution.builder()
                .downloadUrl(createDistributionAttributes.downloadUrl())
                .timeStamp(createDistributionAttributes.timeStamp())
                .accurualPeriodicity(AccurualPeriodicity.ofName(createDistributionAttributes.accurualPeriodicityName()))
                .spatial(createDistributionAttributes.spatial())
                .timeInfo(createDistributionAttributes.timeInfo())
                .build();
    }
}