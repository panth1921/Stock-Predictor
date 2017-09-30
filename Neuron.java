import java.util.Scanner;
public class Neuron {

	
	
	double info;
	double norinput;
	double weight = Math.random();
	Neuron next;
	
	Neuron()
	{
		next = null;
	}
	
	
	
	
	public static void main(String[] args) {
		Network network = new Network();
		
		
		network.backpropagate();
		
	}
	
	
}
