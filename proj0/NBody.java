public class NBody {
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        double radius = NBody.readRadius(fileName);

        StdDraw.setScale(-radius, radius);

        Planet[] planets = NBody.readPlanets(fileName);

        StdDraw.enableDoubleBuffering();
        int time = 0;
        for (; time < T; time += dt) {
            int i = 0;
            int j = 0;
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (; j < planets.length; j++) {
                planets[j].update(dt, xForces[j], yForces[j]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        if (time == T) {
            StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", radius);
            for (Planet planet : planets) {
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planet.xxPos, planet.yyPos, planet.xxVel,
                        planet.yyVel, planet.mass, planet.imgFileName);
            }
        }
    }

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int numberOfPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int i;
        Planet[] planets;
        int numberOfPlanets = in.readInt();
        double radius = in.readDouble();
        planets = new Planet[numberOfPlanets];
        for (i = 0; i < numberOfPlanets; i++) {
            double xCor = in.readDouble();
            double yCor = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xCor, yCor, xVel, yVel, mass, img);
        }
        return planets;
    }

}
