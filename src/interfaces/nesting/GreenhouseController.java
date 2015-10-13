package interfaces.nesting;

import java.util.ArrayList;
import java.util.List;
import static ru.st.print.Print.print;

abstract class Event {
	private long eventTime;
	protected final long delayTime;

	public Event(long delayTime) {
		this.delayTime = delayTime;
		start();
	}

	public void start() { // Позволяет перезапуск
		eventTime = System.nanoTime() + delayTime;
		print("delayTime="+delayTime);
		print("eventTime="+eventTime);
		
	}

	public boolean ready() {
		return System.nanoTime() >= eventTime;
	}

	public abstract void action();
}

class Controller {
	// Класс из пакета java.util для хранения событий Event::
	private List<Event> eventList = new ArrayList<Event>();

	public void addEvent(Event c) {
		eventList.add(c);
	}

	public void run() {
		while (eventList.size() > 0)
			// Make a copy so you're not modifying the list
			// while you're selecting the elements in it:
			for (Event e : new ArrayList<Event>(eventList))
				if (e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
	}
}

class GreenhouseControls extends Controller {
	private boolean light = false;

	public class LightOn extends Event {
		public LightOn(long delayTime) {
			super(delayTime);
		}

		public void action() {
			// Сюда помещается аппаратный вызов
			// физическое включение света
			light = true;
		}

		public String toString() {
			return "Light is on";
		}
	}

	public class LightOff extends Event {
		public LightOff(long delayTime) {
			super(delayTime);
		}

		public void action() {
			// Сюда помещается аппаратный вызов
			// физическое выключение света
			light = false;
		}

		public String toString() {
			return "Light is off";
		}
	}

	private boolean water = false;

	public class WaterOn extends Event {
		public WaterOn(long delayTime) {
			super(delayTime);
		}

		public void action() {
			// Сюда помещается аппаратный вызов.
			// выключения системы полива
			water = true;
		}

		public String toString() {
			return "Greenhouse water is on";
		}
	}

	public class WaterOff extends Event {
		public WaterOff(long delayTime) {
			super(delayTime);
		}

		public void action() {
			// Сюда помещается аппаратный вызов.
			// выключения системы полива
			water = false;
		}

		public String toString() {
			return "Greenhouse water is off";
		}
	}

	private String thermostat = "Day";

	public class ThermostatNight extends Event {
		public ThermostatNight(long delayTime) {
			super(delayTime);
		}

		public void action() {
			// Сюда помещается аппаратный вызов.
			// thermostat = "Ночь";
			thermostat = "Night";
		}

		public String toString() {
			return "Thermostat on night setting";
		}
	}

	public class ThermostatDay extends Event {
		public ThermostatDay(long delayTime) {
			super(delayTime);
		}

		public void action() {
			// Сюда помещается аппаратный вызов.
			// thermostat = "День"
			thermostat = "Day";
		}

		public String toString() {
			return "Thermostat on day setting";
		}
	}

	// Пример метода action(), вставляющего
	// самого себя в список событий.
	public class Bell extends Event {
		public Bell(long delayTime) {
			super(delayTime);
		}

		public void action() {
			addEvent(new Bell(delayTime));
		}

		public String toString() {
			return "Bing!";
		}
	}

	public class Restart extends Event {
		private Event[] eventList;

		public Restart(long delayTime, Event[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for (Event e : eventList)
				addEvent(e);
		}

		public void action() {
			for (Event e : eventList) {
				e.start(); // Перезапуск каждый раз
				addEvent(e);
			}
			start(); // Возвращаем это событие Event
			addEvent(this);
		}

		public String toString() {
			return "Restarting system";
		}
	}

	public static class Terminate extends Event {
		public Terminate(long delayTime) {
			super(delayTime);
		}

		public void action() {
			System.exit(0);
		}

		public String toString() {
			return "Terminating";
		}
	}
}

public class GreenhouseController {
	public static void main(String[] args) {
		GreenhouseControls gc = new GreenhouseControls();
		// Вместо жесткого кодирования фиксированных данных
		// можно было бы считать информацию для настройки
		// из текстового файла:
		       gc.addEvent(gc.new Bell(600000000));
		Event[] eventList = { 
				gc.new ThermostatNight(200000000), 
				        gc.new LightOn(200000000), 
				       gc.new LightOff(200000000), 
				        gc.new WaterOn(200000000),
				       gc.new WaterOff(200000000), 
				  gc.new ThermostatDay(200000000) 
				};
		    gc.addEvent(gc.new Restart(400000000, eventList));
		gc.addEvent(new GreenhouseControls.Terminate(900000000));
		gc.run();
	}
}


class Egg {
	private Yolk y;

	protected class Yolk {
		public Yolk() {
			print("Egg.Yolk()");
		}
	}

	public Egg() {
		print("New Egg()");
		y = new Yolk();
	}
}

class BigEgg extends Egg {
	public class Yolk {
		public Yolk() {
			print("BigEgg.Yolk()");
		}
	}

	public static void main(String[] args) {
		new BigEgg();
	}
}

