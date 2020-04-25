using System;
using System.Threading;
using System.Threading.Tasks;

namespace Lab1Thread
{
	public class HelloOperation
	{
		public void PrintHello()
		{
			for (int i = 0; i < 20; i++)
			{
				Console.WriteLine($"Hello world from another thread: {Thread.CurrentThread.Name}!!!");
				Thread.Sleep(1000);
			}
		}
	}

	class Program
	{
		static void Main(string[] args)
		{
			Thread.CurrentThread.Name = "MainThread";

			HelloOperation op = new HelloOperation();
			Thread newThread = new Thread(op.PrintHello);
			newThread.Name = "Operation[Hello]";
			newThread.Start();

			Task task = new Task(() =>
			{
				Thread.CurrentThread.Name = "Action[Hello]";
				for (int i = 0; i < 20; i++)
				{
					Console.WriteLine($"Hello World from thread: {Thread.CurrentThread.Name}");
					Thread.Sleep(1000);
				}
			});
			task.Start();

			for (int i = 0; i < 20; i++)
			{
				Console.WriteLine($"Hello World from thread: {Thread.CurrentThread.Name}");
				Thread.Sleep(1000);
			}
		}
	}
}
