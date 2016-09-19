import java.util.Iterator;

class ParticleSystem {
    ArrayList<Particle> particles;
    ArrayList<Confetti> confetti;
    PVector origin;

    ParticleSystem(PVector location) {
        origin = location.get();
        particles = new ArrayList<Particle>();
        confetti =  new ArrayList<Confetti>();
    }

    void addParticle() {
        particles.add(new Particle(origin));
        confetti.add(new Confetti(origin));
    }

    void run () {
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
