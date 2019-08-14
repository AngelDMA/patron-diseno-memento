import java.util.ArrayList;

class Caretaker {

	private ArrayList<Memento> mementos = new ArrayList<>();

	public void addMemento(Memento m) {
		mementos.add(m);
	}

	public Memento getMemento(int index) {
		return mementos.get(index);
	}
}

class Juego {

	private String nombre;
	private int checkpoint;

	public int getCheckpoint() {
		return checkpoint;
	}

	public void setCheckpoint(int checkpoint) {
		this.checkpoint = checkpoint;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", checkpoint=" + checkpoint + "]";
	}

}

class Memento {

	private Juego estado;

	public Memento(Juego estado) {
		this.estado = estado;
	}

	public Juego getEstado() {
		return estado;
	}

}

class Originator {

	private Juego estado;

	public void setEstado(Juego estado) {
		this.estado = estado;
	}

	public Juego getEstado() {
		return estado;
	}

	public Memento guardar() {
		return new Memento(estado);
	}

	public void restaurar(Memento m) {
		this.estado = m.getEstado();
	}
}

public class App {

	public static void main(String[] args) {
		String nombreJuego = "Crash Bandicoot";
		
		Juego juego = new Juego();
		juego.setNombre(nombreJuego);
		juego.setCheckpoint(1);

		Caretaker caretaker = new Caretaker();
		Originator originator = new Originator();

		juego = new Juego();
		juego.setNombre(nombreJuego);
		juego.setCheckpoint(2);
		originator.setEstado(juego);

		juego = new Juego();
		juego.setNombre(nombreJuego);
		juego.setCheckpoint(3);		
		originator.setEstado(juego);

		caretaker.addMemento(originator.guardar()); // ESTADO POSICION 0

		juego = new Juego();
		juego.setNombre(nombreJuego);
		juego.setCheckpoint(4);

		originator.setEstado(juego);
		caretaker.addMemento(originator.guardar()); // ESTADO POSICION 1

		juego = new Juego();
		juego.setNombre(nombreJuego);
		juego.setCheckpoint(5);
		originator.setEstado(juego);
		caretaker.addMemento(originator.guardar()); // ESTADO POSICION 2

		originator.setEstado(juego);
		originator.restaurar(caretaker.getMemento(1));

		juego = originator.getEstado();
		System.out.println(juego);
	}

}
