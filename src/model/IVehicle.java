package model;

/**
      * An interface that has the method's you need to move a vehicle
      */
    public interface IVehicle {
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

            /**
             * increases the speed with the help of a double between 0-1
             * @param d
             */
        void gas(double d);
            /**
             * deacreases the speed with the help of a double between 0-1
             * @param d
             */
        void brake(double d);
            /**
             * Start's the vehicle with a little speed and turns it "ON"
             */
        void startEngine();
            /**
             * turns the engine off if the current speed is 0
             */
        void stopEngine();

            /**
             * sets the direction of the vehicle uses the unit circle
             * @param d
             */
        void setDirection(double d);

        double getX();
        double getY();
        double getDirection();
        String getModelName();
        double getCurrentSpeed();
}
