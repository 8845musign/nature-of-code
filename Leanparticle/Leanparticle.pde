ParticleSystem ps;

void setup() {
    size(640, 320);
    ps = new ParticleSystem(new PVector(width/2, 50));
}

void draw() {
    background(255);

    PVector gravity = new PVector(0, 0.2);

    ps.applyForce(gravity);
    ps.addParticle();
    ps.run();
}
