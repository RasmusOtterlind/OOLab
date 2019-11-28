/**
      * An interface that has the method's you need to move
      */
    public interface Movable {
          /**
           * Moves the object based on it's current speed and direction.
           */
        void move();
          /**
           * turns the object left
           */
        void turnLeft();
          /**
           * turns the object right
           */
        void turnRight();
}
