package task3TrianglesSorting.validators;

import task3TrianglesSorting.dto.TriangleDto;

public interface ITriangleValidator {

    void validateTriangleData(TriangleDto dto) throws IllegalArgumentException;
}
