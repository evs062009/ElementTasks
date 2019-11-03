package task3TrianglesSorting.validator;

import common.misc.Response;
import task3TrianglesSorting.misc.ShapeData;

public interface IShapeValidator {

    Response isValid(ShapeData data);
}
