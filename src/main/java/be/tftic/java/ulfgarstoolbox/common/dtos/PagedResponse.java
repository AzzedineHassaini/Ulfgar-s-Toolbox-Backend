package be.tftic.java.ulfgarstoolbox.common.dtos;

import java.util.List;

public record PagedResponse<T> (
        List<T> content,
        Integer pageSize,
        Long totalElements,
        Integer totalPages
) { }
