package common.interfaces;

import task3TrianglesSorting.misc.ShapeData;

public interface IValidator {

    Response isValid(ShapeData data);

    /*Response which returns after validation*/
    class Response {

        private boolean isValid;
        private String message;

        public Response(boolean isValid) {
            this.isValid = isValid;
            this.message = "";
        }

        public Response(boolean isValid, String message) {
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
