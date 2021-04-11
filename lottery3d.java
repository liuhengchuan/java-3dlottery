package lottery;
import java.util.Random;
import java.util.Scanner;


class Study 
{
	private int[] winnumber;
	private String number;
	Study(){};
	public Study(int []a,String b)
	{
		winnumber=a;
		number=b;
	}
	public int[]getwinnumber()
	{
		return winnumber;
	}
	public String getnumber()
	{
		return number;
	}
}
class single extends Study
{
	single(){};
	single(int []a,String b)
	{
		super(a,b);
	}
	int award()
	{
		for(int i=0;i<3;i++)
		{
			if(getnumber().charAt(i)-48!=getwinnumber()[i])
			{
				return 0;
			}
		}
		return 1040;
	}
}
class group extends Study
{
	group(){};
	group(int []a,String b)
	{
		super(a,b);
	}
	int award()
	{
		int num[]=new int [3];
		int check[]=new int [10];
		boolean judge=false;
		boolean match=true;
		for(int i=0;i<3;i++)
		{
			num[i]=getnumber().charAt(i)-48;
			check[num[i]]++;
			if(check[num[i]]==2)
			{
				judge=true;
			}
		}
		for(int i=0;i<3;i++)
		{
			check[getnumber().charAt(i)-48]--;
			if(check[i]<0)
			{
				match=false;
			}
		}
		if(match)
		{
			if(judge)
			{
				return 346;
			}
			else
				return 173;
		}
		else return 0;
	}
}
class oned extends Study
{
	oned(){};
	oned(int []a,String b)
	{
		super(a,b);
	}
	int award()
	{
		int index=0;
		for(int i=0;i<3;i++)
		{
			if(getnumber().charAt(i)-48<='9'&&getnumber().charAt(i)-48>='0')
			{
				index=i;
			}
		}
		if(getwinnumber()[index]==getnumber().charAt(index)-48)
		{
			return 10;
		}
		else
			return 0;
	}
}
class guess1d extends Study
{
	guess1d(){};
	guess1d(int[]a,String b)
	{
		super(a,b);
	}
	int award()
	{
		//int index=0;
		int count=0;
		//boolean judge=true;
		for(int i=0;i<3;i++)
		{
			if(getwinnumber()[i]==getnumber().charAt(0)-48)
			{
				count++;
			}
		}
		/*for(int i=0;i<3;i++)
		{
			if(getnumber().charAt(i)-48<='9'&&getnumber().charAt(i)-48>='0')
			{
				index=i;			
			}
			if(getwinnumber()[index]!=getnumber().charAt(index)-48)
			{
				judge=false;
			}
		}*/
		//if(judge)
		//{
			if(count==0)
			{
				return 0;
			}
			else if(count==1)
			{
				return 2;
			}
			else if(count==2)
			{
				return 12;
			}
			else 
				return 230;
		//}
		//else 
			//return 0;		
	}	
}
class twod extends Study
{
	twod(){};
	twod(int[]a,String b)
	{
		super(a,b);
	}
	int award() 
	{
		int index=0;
		boolean judge=true;
		for(int i=0;i<3;i++)
		{
			if(getnumber().charAt(i)-48<='9'&&getnumber().charAt(i)-48>='0')
			{
				index=i;			
			}
			if(getwinnumber()[index]!=getnumber().charAt(index)-48)
			{
				judge=false;
			}
		}
		if(judge)
		{
			return 104;
		}
		else 
			return 0;
	}
}

class sum extends Study
{
	sum(){};
	sum(int []a,String b)
	{
		super(a,b);
	}
	int award()
	{
		int winsum=0;
		int []numbers= {1040,375,172,104,69,49,37,29,23,19,16,15,15,14};
		for(int i=0;i<3;i++)
		{
			winsum+=getwinnumber()[i];
		}
		int sum;
		sum=Integer.parseInt(getnumber());
		if(winsum==sum||winsum==27-sum)
		{
			return numbers[sum<27-sum?sum:27-sum];
		}
		else
			return 0;
	}
}

class tractor extends Study
{
	tractor(){};
	tractor(int []a,String b)
	{
		super(a,b);
	}
	int award()
	{
		if(getwinnumber()[1]-getwinnumber()[0]==1&&getwinnumber()[2]-getwinnumber()[1]==1)
			return 65;
		else 
			return 0;
	}
}

class guesssame extends Study
{
	guesssame(){};
	guesssame(int[]a,String b)
	{
		super(a,b);
	}
	int award()
	{
		if(getwinnumber()[1]==getwinnumber()[0]&&getwinnumber()[1]==getwinnumber()[2])
			return 104;
		else 
			return 0;
	}
}
class guessparity extends Study
{
	guessparity(){};
	guessparity(int []a,String b)
	{
		super(a,b);
	}
	int award()
	{
		if(getwinnumber()[0]/2==1&&getwinnumber()[1]/2==1&&getwinnumber()[2]/2==1&&getnumber().equals("奇"))
		{
			return 8;
		}
		else if(getwinnumber()[0]/2==0&&getwinnumber()[1]/2==0&&getwinnumber()[2]/2==0&&getnumber().equals("偶"))
			return 8;
		else
			return 0;
	}
}
class guesssize extends Study
{
	guesssize(){};
	guesssize(int[]a,String b)
	{
		super(a,b);
	}
	int award()
	{
		int sum;
		sum=getwinnumber()[0]+getwinnumber()[1]+getwinnumber()[2];
		if(getnumber().equals("大"))
		{
			if(sum>=19)
				return 6;
			else 
				return 0;
		}
		else if(getnumber().equals("小"))
		{
			if(sum<=8)
			{
				return 6;
			}
			else
				return 0;
		}
		else 
			return 0;
		
	}
}
class guess2d extends Study
{
	guess2d(){};
	guess2d(int []a,String b)
	{
		super(a,b);
	}
	int award()
	{
		int a=getnumber().charAt(0)-48;
		int b=getnumber().charAt(1)-48;
		boolean judge=true;
		int []check=new int [10];
		for(int i=0;i<3;i++)
		{
			check[getwinnumber()[i]]++;
		}
		if(a==b)
		{
			check[a]--;
			check[b]--;
			for(int i=0;i<10;i++)
			{
				if(check[i]<0)
					judge=false;
			}
			if(judge)
				return 37;
			else
				return 0;
		}
		else
		{
			check[a]--;
			check[b]--;
			for(int i=0;i<10;i++)
			{
				if(check[i]<0)
					judge=false;
			}
			if(judge)
				return 19;
			else
				return 0;
		}
	}
}

class general extends Study
{
	general(){};
	general(int[]a,String b)
	{
		super(a,b);
	}
	int award()
	{
		int num=0;
		for(int i=0;i<3;i++)
		{
			if(getwinnumber()[i]==getnumber().charAt(i)-48)
			{
				num++;
			}
		}
		if(num==3)
		{
			return 470;
		}
		else if(num==2)
		{
			return 21;
		}
		else return 0;
	}
}
class package1 extends Study
{
	package1(){};
	package1(int []a,String b)
	{
		super(a,b);
	}
	int award()
	{
		boolean judgesame=true;
		int check[]=new int[10];
		for(int i=0;i<3;i++)
		{
			check[getwinnumber()[i]]++;
			if(check[getwinnumber()[i]]>=2)
			{
				judgesame=false;
			}
		}
		boolean judge=true;
		if(judgesame)//包选6；
		{
			boolean same=true;
			for(int i=0;i<3;i++)
			{
				if(getwinnumber()[i]!=getnumber().charAt(i)-48)
					same=false;
			}
			if(same)
			{
				return 606;
			}
			else
			{
				for(int i=0;i<3;i++)
				{
					check[getnumber().charAt(i)-48]--;
					if(check[getnumber().charAt(i)-48]<0)
					{
						judge=false;
					}
				}
				if(judge)
					return 86;
				else return 0;
			}
		}
		else
		{
			boolean same=true;
			for(int i=0;i<3;i++)
			{
				if(getwinnumber()[i]!=getnumber().charAt(i)-48)
					same=false;
			}
			if(same)
			{
				return 693;
			}
			else
			{
				for(int i=0;i<3;i++)
				{
					check[getnumber().charAt(i)-48]--;
					if(check[getnumber().charAt(i)-48]<0)
					{
						judge=false;
					}
				}
				if(judge)
					return 173;
				else return 0;
			}
		}
	}
}
public class lottery3d {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
				System.out.print("请输入投注方式");
				Random rand=new Random();
				Scanner s=new Scanner(System.in);
				String pattern;
				pattern=s.next();
						if(pattern.equals("single"))
						{
							int r=rand.nextInt(900)+100;
							
							int []winnumber1=new int [3];
							System.out.print("中奖号为：");
							for(int i=0;i<3;i++)
							{
								winnumber1[2-i]=r%10;
								r/=10;
							}
							for(int i=0;i<3;i++)
							{
								System.out.print(winnumber1[i]+" ");
							}
							System.out.println();
							System.out.print("请输入0-999之间的整数");
							String usernumber2;
							usernumber2=s.next();
							int award=0;
							if(usernumber2.length()>3)
							{
								System.out.println("请输入正确的投注内容");
								System.out.print("请输入0-999之间的整数");
							}
							else
							{
								single a=new single(winnumber1,usernumber2);
								award=a.award();
								System.out.println("您获得的奖金为"+award);
							}
						}
						else if(pattern.equals("group"))
						{
							int r=rand.nextInt(900)+100;
							
							int []winnumber1=new int [3];
							System.out.print("中奖号为：");
							for(int i=0;i<3;i++)
							{
								winnumber1[2-i]=r%10;
								r/=10;
							}
							for(int i=0;i<3;i++)
							{
								System.out.print(winnumber1[i]+" ");
							}
							System.out.println();
							System.out.print("请输入0-999之间的整数");
							String usernumber2;
							usernumber2=s.next();
							int award=0;
							if(usernumber2.length()>3)
							{
								System.out.println("请输入正确的投注内容");
								System.out.print("请输入0-999之间的整数");
							}
							else
							{
								group a=new group(winnumber1,usernumber2);
								award=a.award();
								System.out.println("您获得的奖金为"+award);
							}
						}
						else if(pattern.equals("oned"))
						{
							int r=rand.nextInt(900)+100;
							
							int []winnumber1=new int [3];
							System.out.print("中奖号为：");
							for(int i=0;i<3;i++)
							{
								winnumber1[2-i]=r%10;
								r/=10;
							}
							for(int i=0;i<3;i++)
							{
								System.out.print(winnumber1[i]+" ");
							}
							System.out.println();
							System.out.print("请输入确定位置的一个数字，其他位输入*，例如，如果确定个位数为2，请输入**2");
							String usernumber2;
							usernumber2=s.next();
							int award=0;
							if(usernumber2.length()>3)
							{
								System.out.println("请输入正确的投注内容");
								System.out.print("请输入确定位置的一个数字，其他位输入*，例如，如果确定个位数为2，请输入**2");
							}
							else 
							{
								oned a=new oned(winnumber1,usernumber2);
								award=a.award();
								System.out.println("您获得的奖金为"+award);
							}
						}
						else if(pattern.equals("guess1d"))
						{
							int r=rand.nextInt(900)+100;
							
							int []winnumber1=new int [3];
							System.out.print("中奖号为：");
							for(int i=0;i<3;i++)
							{
								winnumber1[2-i]=r%10;
								r/=10;
							}
							for(int i=0;i<3;i++)
							{
								System.out.print(winnumber1[i]+" ");
							}
							System.out.println();
							System.out.print("请输入确定位置的一个数字，其他位输入*，例如，如果确定个位数为2，请输入**2");
							String usernumber2;
							usernumber2=s.next();
							int award=0;
							if(usernumber2.length()>3)
							{
								System.out.println("请输入正确的投注内容");
								System.out.print("请输入确定位置的一个数字，其他位输入*，例如，如果确定个位数为2，请输入**2");
							}
							else
							{
								guess1d a=new guess1d(winnumber1,usernumber2);
								award=a.award();
								System.out.println("您获得的奖金为"+award);
							}
						}
						else if(pattern.equals("general"))
						{
							int r=rand.nextInt(900)+100;
							
							int []winnumber1=new int [3];
							System.out.print("中奖号为：");
							for(int i=0;i<3;i++)
							{
								winnumber1[2-i]=r%10;
								r/=10;
							}
							for(int i=0;i<3;i++)
							{
								System.out.print(winnumber1[i]+" ");
							}
							System.out.println();
							System.out.print("请输入0-999之间的整数");
							String usernumber2;
							usernumber2=s.next();
							int award=0;
							if(usernumber2.length()>3)
							{
								System.out.println("请输入正确的投注内容");
								System.out.print("请输入0-999之间的整数");
							}
							else
							{
								general a=new general(winnumber1,usernumber2);
								award=a.award();
								System.out.println("您获得的奖金为"+award);
							}
						}
						else if(pattern.equals("sum"))
						{
							int r=rand.nextInt(900)+100;
							
							int []winnumber1=new int [3];
							System.out.print("中奖号为：");
							for(int i=0;i<3;i++)
							{
								winnumber1[2-i]=r%10;
								r/=10;
							}
							for(int i=0;i<3;i++)
							{
								System.out.print(winnumber1[i]+" ");
							}
							System.out.println();
							System.out.print("请输入三位数之和");
							String usernumber2;
							usernumber2=s.next();
							int award=0;
							if(usernumber2.length()>3)
							{
								System.out.println("请输入正确的投注内容");
								System.out.print("请输入0-999之间的整数");
							}
							else
							{
								sum a=new sum(winnumber1,usernumber2);
								award=a.award();
								System.out.println("您获得的奖金为"+award);
							}
						}
						else if(pattern.equals("package"))
						{
							int r=rand.nextInt(900)+100;
							
							int []winnumber1=new int [3];
							System.out.print("中奖号为：");
							for(int i=0;i<3;i++)
							{
								winnumber1[2-i]=r%10;
								r/=10;
							}
							for(int i=0;i<3;i++)
							{
								System.out.print(winnumber1[i]+" ");
							}
							System.out.println();
							System.out.print("请输入0-999之间的整数");
							String usernumber2;
							usernumber2=s.next();
							int award=0;
							if(usernumber2.length()>3)
							{
								System.out.println("请输入正确的投注内容");
								System.out.print("请输入0-999之间的整数");
							}
							else
							{
								package1 a=new package1(winnumber1,usernumber2);
								award=a.award();
								System.out.println("您获得的奖金为"+award);
							}
						}
						else if(pattern.equals("tractor"))
						{
							int r=rand.nextInt(900)+100;
							
							int []winnumber1=new int [3];
							System.out.print("中奖号为：");
							for(int i=0;i<3;i++)
							{
								winnumber1[2-i]=r%10;
								r/=10;
							}
							for(int i=0;i<3;i++)
							{
								System.out.print(winnumber1[i]+" ");
							}
							System.out.println();
							System.out.print("请输入0-999之间的整数");
							String usernumber2;
							usernumber2=s.next();
							int award=0;
							if(usernumber2.length()>3)
							{
								System.out.println("请输入正确的投注内容");
								System.out.print("请输入0-999之间的整数");
							}
							else
							{
								tractor a=new tractor(winnumber1,usernumber2);
								award=a.award();
								System.out.println("您获得的奖金为"+award);
							}
						}
						else
							System.out.println("您输入的投注方式不存在，请重新输入");
						
					}
				
}



