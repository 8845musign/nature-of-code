import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Iterator; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Leanparticle extends PApplet {

ParticleSystem ps;

public void setup() {
    
    ps = new ParticleSystem(new PVector(width/2, 50));
}

public void draw() {
    background(255);
    ps.addParticle();
    ps.run();
}
class Confetti extends Particle {
    Confetti(PVector l) {
        super(l);
    }

    public void display() {
        float theta = map(location.x, 0, width, 0, TWO_PI*2);
        rectMode(CENTER);

        fill(175, lifespan);;
        stroke(0, lifespan);

        pushMatrix();
        translate(location.x, location.y);
        rotate(theta);
        rect(0, 0, 8, 8);
        popMatrix();
    }
}
class Particle {
    PVector location;
    PVector velocity;
    PVector acceleration;
    float lifespan;

    Particle(PVector l) {
        location        = l.get();
        acceleration    = new PVector(0, 0.05f);
        velocity        = new PVector(random(-1, 1), random(-2, 0));
        lifespan        = 255.0f;
    }

    public void run() {
        update();
        display();
    }

    public void update() {
        velocity.add(acceleration);
        location.add(velocity);
        lifespan -= 2.0f;
    }

    public void display() {
        stroke(0, lifespan);
        fill(175, lifespan);
        ellipse(location.x, location.y, 8, 8);
    }

    public boolean isDead() {
        if (lifespan < 0.0f) {
            return true;
        }

        return false;
    }
}


class ParticleSystem {
    ArrayList<Particle> particles;
    ArrayList<Confetti> confetti;
    PVector origin;

    ParticleSystem(PVector location) {
        origin = location.get();
        particles = new ArrayList<Particle>();
        confetti =  new ArrayList<Confetti>();
    }

    public void addParticle() {
        particles.add(new Particle(origin));
        confetti.add(new Confetti(origin));
    }

    public void run () {
        Iterator<Particle> it = particles.iterator();
        while(it.hasNext()) {
            Particle p = it.next();
            p.run();

            if (p.isDead()) {
                it.remove();
            }
        }

        Iterator<Confetti> it2 = confetti.iterator();
        while(it2.hasNext()) {
            Confetti c = it2.next();
            c.run();

            if (c.isDead()) {
                it2.remove();
            }
        }
    }
}
  public void settings() {  size(640, 320); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Leanparticle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
