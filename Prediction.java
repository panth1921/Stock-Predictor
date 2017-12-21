

public class Prediction {
	
	
	
	
	
	
	 Neuron[]  i = new Neuron[4];
	 Neuron[] h = new Neuron[5];
	 Neuron output = new Neuron();
	 
	
	 boolean errorflag = true;
	 int epochnumber = 0;
	 
	 double[] neth = new double[5];
	 double[] outh = new double[5];
	 double neto = 0.0;
	 
	 double[] weights_0 = {  0.05178749815237892, 0.969952816070175, 0.5040511565311045, 0.8230216906277084  };
	 double[] adweights_0 = null;
	
	 double[] weights_1 = {   0.2148748643964234, 0.24464713689632075, 0.4933478630765177, 0.9840350540247489   };
	 double[] adweights_1 = null;
	
	 double[] weights_2 = { 0.726997500581757, 0.8663149254639637, 0.9408467982096147, 0.8627744570531086  };
	 double[] adweights_2 = null;
	
	 double[] weights_3 = { 0.39273648668219957, 0.3914199459703904, 0.8144837953752713, 0.37462068884080757  };
	 double[] adweights_3 = null;
	
	 double[] weights_4 = {   0.14198116153567802, 0.9068670975210329, 0.025943493202651664, 0.9532684181444002  };
	 double[] adweights_4 = null;
   
	 double[] weightshidden = { 0.7217405677342362, 0.9056430068603538, 1.0114577971401812, 0.7839446260164247, 0.40733203744024826 };
	 double[] adweightshidden = null;
	 
	 
	 
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
		
		i[0].info = 113.84;
		i[1].info = 115.92;
		i[2].info = 113.75;
		i[3].info = 115.19;
					
																																																																		
																																					
		
		
		for(int j=0;j<4;j++)
		{
			i[j].norinput = (((i[j].info - 1)/116) * 2) - 1;
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
			
			errorflag = false;
			for(int y=0;y<4;y++)
			{
			h[0].info += i[y].norinput * weights_0[y];
			}
					
			for(int y=0;y<4;y++)
			{
			h[1].info += i[y].norinput * weights_1[y];
			}
			
			for(int y=0;y<4;y++)
			{
			h[2].info += i[y].norinput * weights_2[y];
			}
			
			for(int y=0;y<4;y++)
			{
			h[3].info += i[y].norinput * weights_3[y];
			}
			
			for(int y=0;y<4;y++)
			{
			h[4].info += i[y].norinput * weights_4[y];
			}
				
				
				for(int x=0;x<5;x++)
				{
			 
					outh[x] = 1/( 1 + Math.pow(Math.E,(-1*h[x].info)));
					
					System.out.println("h = "+ h[0].info + " " + h[1].info + " " + h[2].info + " " + h[3].info + " " + h[4].info + " ");
					
			 
					neto += outh[x] * weightshidden[x];
				}
			
			
				System.out.println("neto = " + neto);
				output.info = 1/( 1 + Math.pow(Math.E,(-1*neto)));
				System.out.println("output = " + output.info);
				System.out.println("Prediction = " + (((1+output.info)*116)/2)+1);
	 

}
		
		
		}
}
 