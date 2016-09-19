class Repeller {
  float strength = 100;
  PVector location;
  float r = 10;

  Repeller(float x, float y) {
    location = new PVector(x, y);
  }

  void display() {
    stroke(0);
    fill(255);
    ellipse(location.x,location.y, r *2, r*2);
  }

  PVector repel(Particle p) {
    PVector dir = PVector.sub(location, p.location);
    float d  = dir.mag();
    d = constrain(d, 5, 100);
    dir.normalize();
    float force = -1 * strength / (d * d);
    dir.mult(force);
    return dir;
  }
}
