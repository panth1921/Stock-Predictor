import java.util.Scanner;
public class Network {
	
	
	
	 Neuron[]  i = new Neuron[4];
	 Neuron[] h = new Neuron[5];
	 Neuron output = new Neuron();
	
	 double  error = 0.0;
	 boolean errorflag = true;
	 int epochnumber = 0;
	
	 double[] weights_0 = {Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweights_0 = null;
	
	 double[] weights_1 = {Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweights_1 = null;
	
	 double[] weights_2 = {Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweights_2 = null;
	
	 double[] weights_3 = {Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweights_3 = null;
	
	 double[] weights_4 = {Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweights_4 = null;
	 
	 double[] weights_5 = {Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweights_5 = null;
	
	 double[] weights_6 = {Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweights_6 = null;
	
	 double[] weights_7 = {Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweights_7 = null;
	
	 double[] weights_8 = {Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweights_8 = null;
	
	
   
	 double[] weightshidden = {Math.random(),Math.random(),Math.random(),Math.random(),Math.random()};
	 double[] adweightshidden = null;
   
	 double[] neth = new double[5];
	 double[] outh = new double[5];
	 double neto = 0.0; 
    double  targetresult = 153.28		;
    double nortargetresult = (((targetresult - 1)/153.28) * 2) - 1;
	
	public void backpropagate() 
	{
	for(int j=0;j<4;j++)
	{
		 i[j] = new Neuron();
	}
	
	for(int j=0;j<5;j++)
	{
		 h[j] = new Neuron();
	}
	
	i[0].info = 153.80;
	i[1].info = 154.72;
	i[2].info = 153.54;
	i[3].info = 154.23;
																					
																									
	
	for(int j=0;j<4;j++)
	{
		i[j].norinput = (((i[j].info - 1)/153.28) * 2) - 1;
	}
	
	for(int k=0;k<5;k++)
	{
		for(int j=0;j<4;j++)
		{
			i[j].next = h[k];
		}
		h[k].next = output;
		
	}
	
	while(errorflag == true)
	{
		for(int i=0;i<5;i++)
		{
			h[i].info = 0.0;
		}
		System.out.println("prediction0 real weights are below!!!");
		System.out.println("w1 = " + weights_0[0] + ", " + weights_0[1]  + ", " + weights_0[2] + ", " + weights_0[3]);
 	 	System.out.println("w1 = " + weights_1[0] + ", " + weights_1[1]  + ", " + weights_1[2] + ", " + weights_1[3]);
	    System.out.println("w1 = " + weights_2[0] + ", " + weights_2[1]  + ", " + weights_2[2] + ", " + weights_2[3]);
	 	System.out.println("w1 = " + weights_3[0] + ", " + weights_3[1]  + ", " + weights_3[2] + ", " + weights_3[3]);
		System.out.println("w1 = " + weights_4[0] + ", " + weights_4[1]  + ", " + weights_4[2] + ", " + weights_4[3]);
		System.out.println("hw1 = " + weightshidden[0] + ", " + weightshidden[1] + ", " + weightshidden[2] + ", " + weightshidden[3] + ", " + weightshidden[4]);
		
		errorflag= false;
		
		for(int y=0;y<4;y++)
		{
			
		h[0].info += i[y].norinput * weights_0[y];
		System.out.println("h[0] = " +h[0].info);
		}
				
		for(int y=0;y<4;y++)
		{
			
		h[1].info += i[y].norinput * weights_1[y];
		System.out.println("h[1] = " +h[1].info);
		}
		
		for(int y=0;y<4;y++)
		{
				
		h[2].info += i[y].norinput * weights_2[y];
		System.out.println("h[2] = " +h[2].info);
		}
		
		for(int y=0;y<4;y++)
		{
				
		h[3].info += i[y].norinput * weights_3[y];
		System.out.println("h[3] = " +h[3].info);
		}
		
		for(int y=0;y<4;y++)
		{
		
		h[4].info += i[y].norinput * weights_4[y];
		System.out.println("h[4] = " +h[4].info);
		}
			
			
			for(int x=0;x<5;x++)
			{
		 
				outh[x] = 1/( 1 + Math.pow(Math.E,(-1*h[x].info)));
			}
			for(int x=0;x<5;x++)
			{
		  	neto += outh[x] * weightshidden[x];
			}
		 
			output.info = 1/( 1 + Math.pow(Math.E,(-1*neto)));
		 
			error = ((nortargetresult-output.info) * (nortargetresult-output.info))/2;
			
			System.out.println("error =" + error );
			System.out.println("neto0 = " + neto);
			System.out.println("output = " + output.info);
			System.out.println("Prediction0 = " + (((1+output.info)*153.28)/2)+1);
			
			for(int i=0;i<5;i++)
			{
				h[i].info = 0.0;
			}
			
			if(error > 0.000000001 )
			 {
		 	
		 	
		 		epochnumber++;
		 		System.out.println("Epochnumber = " + epochnumber );
	            errorflag = true;
	            
	            
	            adweightshidden = adjustingweightsh(weightshidden,outh);
	            adweights_0 = adjustingweights(weights_0,outh);
	        	adweights_1 = adjustingweights(weights_1,outh);
	        	adweights_2 = adjustingweights(weights_2,outh);
	        	adweights_3 = adjustingweights(weights_3,outh);
	        	adweights_4 = adjustingweights(weights_4,outh);
	            
	            
	    System.out.println("w1 = " + weights_0[0] + " w2 =" + weights_0[1]  + " w3 =" + weights_0[2] + " w4 =" + weights_0[3]);
 	 	System.out.println("w1 = " + weights_1[0] + " w2 =" + weights_1[1]  + " w3 =" + weights_1[2] + " w4 =" + weights_1[3]);
	    System.out.println("w1 = " + weights_2[0] + " w2 =" + weights_2[1]  + " w3 =" + weights_2[2] + " w4 =" + weights_2[3]);
	 	System.out.println("w1 = " + weights_3[0] + " w2 =" + weights_3[1]  + " w3 =" + weights_3[2] + " w4 =" + weights_3[3]);
		System.out.println("w1 = " + weights_4[0] + " w2 =" + weights_4[1]  + " w3 =" + weights_4[2] + " w4 =" + weights_4[3]);
		System.out.println("hw1 = " + weightshidden[0] + " hw2 =" + weightshidden[1] + "hw3 =" + weightshidden[2] + " hw4 =" + weightshidden[3] + " hw5 =" + weightshidden[4]);
			 	
		System.out.println("adw1 = " + adweights_0[0] + " adw2 =" + adweights_0[1]  + " adw3 =" + adweights_0[2] + " adw4 =" + adweights_0[3]);
		System.out.println("adw1 = " + adweights_1[0] + " adw2 =" + adweights_1[1]  + " adw3 =" + adweights_1[2] + " adw4 =" + adweights_1[3]);
		System.out.println("adw1 = " + adweights_2[0] + " adw2 =" + adweights_2[1]  + " adw3 =" + adweights_2[2] + " adw4 =" + adweights_2[3]);
	    System.out.println("adw1 = " + adweights_3[0] + " adw2 =" + adweights_3[1]  + " adw3 =" + adweights_3[2] + " adw4 =" + adweights_3[3]);
		System.out.println("adw1 = " + adweights_4[0] + " adw2 =" + adweights_4[1]  + " adw3 =" + adweights_4[2] + " adw4 =" + adweights_4[3]);				 	
		System.out.println("adhw1 = "+adweightshidden[0] + "adhw2 =" + adweightshidden[1] + "adhw3 =" + adweightshidden[2] + " adhw4 =" + adweightshidden[3] + " adhw5 =" + adweightshidden[4]);
			
		System.out.println("neto1 = " + neto);
		System.out.println("error = " + error);
		System.out.println("output = " + output.info);
		System.out.println("Prediction1 = " + (((1+output.info)*153.28)/2)+1);
		 	
		 	
	           
	            weightshidden = adweightshidden;
	            weights_0 = adweights_0;
		 		weights_1 = adweights_1;
		 		weights_2 = adweights_2;
		 		weights_3 = adweights_3;
		 		weights_4 = adweights_4;
		 		
		 		for(int i=0;i<5;i++)
				{
					h[i].info = 0.0;
				}
		 		neto = 0.0;
			 }
		 
		}
	 }
	public  double[] adjustingweights(double[] weights,double[] outh )
		{
		
		
		double[] adweights = new double[weights.length];
		for(int z=0;z<weights.length;z++)
			{
				for(int y=0;y<weights.length;y++)
					{
						adweights[y] = weights[y] - (0.2 * (output.info - nortargetresult) * (output.info) * (1 - output.info) * (outh[z]) * (1 - outh[z]) * (weightshidden[z]) * (i[y].norinput));
					}
			}
		
		return adweights;
	}
	
	public  double[] adjustingweightsh(double[] weights,double[] outh)
	{
		
		double[] adweights = new double[weights.length];
		for(int x=0;x<weights.length;x++)
		{
		adweights[x] = weights[x] - ((0.2) * (output.info-nortargetresult) * (output.info) * (1 - output.info) * (outh[x]));
		}
		return adweights;
		
	}
	

}

 