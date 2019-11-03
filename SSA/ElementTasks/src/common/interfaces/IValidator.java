package common.interfaces;

import task3TrianglesSorting.misc.ShapeData;

public interface IValidator {

    Responce isValid(ShapeData data);

    class Responce {
        private boolean isValid;
        private String message;

        public Responce(boolean isValid) {
            this.isValid = isValid;
            this.message = "";
        }

        public Responce(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getMessage() {
            return message;
        }
    }
}
