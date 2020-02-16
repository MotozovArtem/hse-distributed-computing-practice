using System;
using System.IO;

namespace IndividualConsole
{
	class Program
	{
		static void Main(string[] args)
		{
            string path = @"../SomeDir2";
            DirectoryInfo dirInfo = new DirectoryInfo(path);
            if (!dirInfo.Exists)
            {
                dirInfo.Create();
            }
            Console.WriteLine("Введите строку для записи в файл:");
            string text = Console.ReadLine();

            using (FileStream writer = new FileStream($"{path}\\note.txt", FileMode.OpenOrCreate))
            {
                byte[] array = System.Text.Encoding.Default.GetBytes(text);
                writer.Write(array, 0, array.Length);
                Console.WriteLine("Текст записан в файл");
            }

            using (FileStream reader = File.OpenRead($"{path}\\note.txt"))
            {
                byte[] array = new byte[reader.Length];
                reader.Read(array, 0, array.Length);
                string textFromFile = System.Text.Encoding.Default.GetString(array);
                Console.WriteLine($"Текст из файла: {textFromFile}");
            }

            Console.ReadLine();
        }
	}
}
