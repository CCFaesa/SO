package filosofosGulosos;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProblemaDosFilosofosGlutoes{
	public static void main(String args[]){
		System.out.println("XX> COMECOU <XX");
		long time = System.currentTimeMillis();
		
		// cria os grafos (coleção de 5 garfos)
		List<Garfo>garfos = new ArrayList<Garfo>();
		for (int i = 0; i<=4; i++){
			Garfo garfo = new Garfo(i);
			garfos.add(i,garfo);
		}
		// cria a thread do filosofo 0
		FilosofoGlutao r0 = new FilosofoGlutao(garfos, 0);
		Thread f0 = new Thread(r0);
		// cria a thread do filosofo 1
		FilosofoGlutao r1 = new FilosofoGlutao(garfos, 1);
		Thread f1 = new Thread(r1);
		// cria a thread do filosofo 2
		FilosofoGlutao r2 = new FilosofoGlutao(garfos, 2);
		Thread f2 = new Thread(r2);
		// cria a thread do filosofo 3
		FilosofoGlutao r3 = new FilosofoGlutao(garfos, 3);
		Thread f3 = new Thread(r3);
		// cria a thread do filosofo 4
		FilosofoGlutao r4 = new FilosofoGlutao(garfos, 4);
		Thread f4 = new Thread(r4);		
		
		// nomeia as threads
		f0.setName("F0");
		f1.setName("F1");
		f2.setName("F2");
		f3.setName("F3");
		f4.setName("F4");
		
		// manda as threads pra fila de pronto
		f0.start();
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		
		while(true) {
			if(!f0.isAlive() && !f1.isAlive() && !f2.isAlive() && !f3.isAlive() && !f4.isAlive()) {
				long tempoTotal = System.currentTimeMillis() - time;
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			    Date resultdate = new Date(tempoTotal);
			    
				System.out.println("XX> ACABOU COM " + sdf.format(resultdate) + "ms");
				break;
			}
			
			try { Thread.sleep(200); } catch (InterruptedException e) {}
		}
	}
}