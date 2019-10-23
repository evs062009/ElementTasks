package task3TrianglesSorting;

import task3TrianglesSorting.domains.Triangle;
import task3TrianglesSorting.dto.TriangleDto;
import task3TrianglesSorting.input.ITriangleInput;
import task3TrianglesSorting.output.ITrianglesOutput;
import task3TrianglesSorting.services.ITrianglesSorting;
import task3TrianglesSorting.validators.ITriangleValidator;
import utilities.IOUtilities;

import java.util.LinkedList;
import java.util.List;

class App {

    private ITriangleInput input;
    private ITriangleValidator validator;
    private ITrianglesSorting sorting;
    private ITrianglesOutput output;

    App(ITriangleInput input, ITriangleValidator validator,
        ITrianglesSorting sorting, ITrianglesOutput output) {
        this.input = input;
        this.validator = validator;
        this.sorting = sorting;
        this.output = output;
    }

    void execute() {
        List<Triangle> triangles = new LinkedList<>();

        do {
            try {
                TriangleDto dto = input.inputTriangleData();
                validator.validateTriangleData(dto);
                triangles.add(new Triangle(dto));
            } catch (IllegalArgumentException ex) {
                IOUtilities.println(ex.getMessage());
            }
        } while (IOUtilities.isContinue());

        sorting.sortTriangles(triangles);
        output.printTriangles(triangles);
    }
}
