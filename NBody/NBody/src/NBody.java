import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Math;

public class NBody {
    private static final double g = 9.8;
    private static final double e = 0.8;
    public double mass;
    public double size;
    public Position position;
    public Velocity velocity;
    public Accelerate accelerate;

    public static class Position {
        public double x;
        public double y;

        public Position(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Velocity {
        public double vx;
        public double vy;

        public Velocity(double vx, double vy) {
            this.vx = vx;
            this.vy = vy;
        }
    }

    public static class Accelerate {
        public double ax;
        public double ay;

        public Accelerate(double ax, double ay) {
            this.ax = ax;
            this.ay = ay;
        }
    }

    public NBody(double mass, double size, Position position, Velocity velocity, Accelerate accelerate) {
        this.size = size;
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
        this.accelerate = accelerate;
    }
    
    public static void begin(ArrayList<NBody> nbodyList, double dt) {
        for (int i = 0; i < nbodyList.size(); i++) {
            NBody nbody = nbodyList.get(i);
            nbody.accelerate.ax = 0;
            nbody.accelerate.ay = g;
            nbody.position.x = nbody.position.x + nbody.velocity.vx*dt + 0.5*nbody.accelerate.ax*Math.pow(dt, 2);
            nbody.position.y = nbody.position.y + nbody.velocity.vy*dt + 0.5*nbody.accelerate.ay*Math.pow(dt, 2);
            nbody.velocity.vx = nbody.velocity.vx + nbody.accelerate.ax*dt;
            nbody.velocity.vy = nbody.velocity.vy + nbody.accelerate.ay*dt;
            if (nbody.position.y + nbody.size >= 500) {
                nbody.position.y = 500 - nbody.size;
                nbody.velocity.vy = -e*nbody.velocity.vy;
            }
        }
    }
    
}