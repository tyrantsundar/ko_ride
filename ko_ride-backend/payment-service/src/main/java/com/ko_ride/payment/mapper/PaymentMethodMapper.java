package com.ko_ride.payment.mapper;

import com.ko_ride.payment.dto.PaymentMethodDto;
import com.ko_ride.payment.entity.PaymentMethod;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMethodMapper {

    PaymentMethod toEntity(PaymentMethodDto dto);

    PaymentMethodDto toDto(PaymentMethod entity);

    List<PaymentMethod> toEntityList(List<PaymentMethodDto> dtoList);

    List<PaymentMethodDto> toDtoList(List<PaymentMethod> entityList);
}
