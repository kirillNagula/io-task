package by.nagula;


import by.nagula.service.FileService;

public class App
{
    public static void main( String[] args )
    {
        FileService fileService = new FileService("in.txt", "out.txt");
        fileService.start();
    }
}
