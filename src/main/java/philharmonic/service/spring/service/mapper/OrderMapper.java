package philharmonic.service.spring.service.mapper;

import philharmonic.service.spring.dto.response.OrderResponseDto;
import philharmonic.service.spring.model.Order;
import philharmonic.service.spring.model.Ticket;
import philharmonic.service.spring.util.DateTimePatternUtil;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setOrderTime(order.getOrderTime().format(formatter));
        responseDto.setTicketIds(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
