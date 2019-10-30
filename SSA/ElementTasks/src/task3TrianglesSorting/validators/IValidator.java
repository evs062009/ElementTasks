package task3TrianglesSorting.validators;

import task3TrianglesSorting.dto.TriangleDto;

public interface IValidator {

    void validate(TriangleDto dto) throws IllegalArgumentException;
}
