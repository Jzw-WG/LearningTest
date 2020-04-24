package Sound;
import javax.sound.midi.*;

public class MiniMiniApp {
	public static void main(String[] args) {
		MiniMiniApp mini = new MiniMiniApp();
		if (args.length < 2) {
			System.out.println("Dont forget the instrement and note args");
		} else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			mini.play(instrument, note);
		}
	}
	
	public void play(int instrument, int note) {
		try {
			
			Sequencer player = MidiSystem.getSequencer();//取得Sequence
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();//取得track
			
			MidiEvent event = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);//发出44音符
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);			
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, note, 100);//发出44音符
			MidiEvent noteOn = new MidiEvent(a, 1);//第一拍启动a这个message
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
