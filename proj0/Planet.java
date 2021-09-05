public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xVel, double yVel, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xVel;
        yyVel = yVel;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double xDiff = p.xxPos - this.xxPos;
        double yDiff = p.yyPos - this.yyPos;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public double calcForceExertedBy(Planet p) {
        double R = calcDistance(p);
        double G = 6.67e-11;
        return (G * this.mass * p.mass) / (R * R);
    }

    public double calcForceExertedByX(Planet p) {
        double Dx = p.xxPos - this.xxPos;
        double R = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F * Dx / R;
    }

    public double calcForceExertedByY(Planet p) {
        double Dy = p.yyPos - this.yyPos;
        double R = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F * Dy / R;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        int i;
        double Fnetx = 0;
        int len = allPlanets.length;
        for (i = 0; i < len; i++) {
            if (this.equals(allPlanets[i])) {
                continue;
            }
            Fnetx += calcForceExertedByX(allPlanets[i]);
        }
        return Fnetx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        int i;
        double Fnety = 0;
        int len = allPlanets.length;
        for (i = 0; i < len; i++) {
            if (this.equals(allPlanets[i])) {
                continue;
            }
            Fnety += calcForceExertedByY(allPlanets[i]);
        }
        return Fnety;
    }

    public void update(double dt, double fx, double fy) {
        double anetx = fx / this.mass;
        double anety = fy / this.mass;
        this.xxVel = this.xxVel + dt * anetx;
        this.yyVel = this.yyVel + dt * anety;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        String pathToImgFile = String.format("./images/%s", this.imgFileName);
        StdDraw.picture(this.xxPos, this.yyPos, pathToImgFile);
    }
}
