ParticleSystem ps;
Repeller repeller;

void setup() {
    size(640, 320);
    ps = new ParticleSystem(new PVector(width/2, 50));
    repeller = new Repeller(width/2, height/2 - 20);
}

void draw() {
    background(255);
    ps.addParticle();
    PVector gravity = new PVector(0, 0.1);
    ps.applyRepeller(repeller);
    ps.applyForce(gravity);

    repeller.display();
    ps.run();

}
