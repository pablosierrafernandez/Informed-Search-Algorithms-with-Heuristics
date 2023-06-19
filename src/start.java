package src;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class start {

	static final int MAX_ROWS = 10;
	static final int MAX_COLUMNS = 10;
	static int[][] map = new int[MAX_ROWS][MAX_COLUMNS];
	static Scanner key_input = new Scanner(System.in);
	static box initial_position, final_position;
	static tractates tractates_boxes;
	static pending pending;
	static heuristic heuristic;
	static int nodes;
	static Walk walk;

	private static void StartEndPositions() {
		// TODO Auto-generated method stub
		StringTokenizer token;
		String position;
		int initial_row, initial_column, final_row, final_column;
		
		System.out.println("Write your initial position -> R,C");
		position = key_input.nextLine();
		token = new StringTokenizer(position, ",");
		initial_row = Integer.parseInt(token.nextToken());
		initial_column = Integer.parseInt(token.nextToken());
		
		System.out.println("Write your final position -> R,C");
		position = key_input.nextLine();
		token = new StringTokenizer(position, ", ");
		final_row = Integer.parseInt(token.nextToken());
		final_column = Integer.parseInt(token.nextToken());
		
		initial_position = new box(map[initial_row][initial_column], initial_row, initial_column);
		final_position = new box(map[final_row][final_column], final_row, final_column);
		
		if (initial_position.getHeight()==-1 || final_position.getHeight()==-1)
		{
			System.out.println("ERROR -> Position is invalid");
			StartEndPositions();
		}
	}
	public static void ReadFile(String file_name) {
		// TODO Auto-generated method stub
		BufferedReader file;
		StringTokenizer token;
		String line;
		int column, row=0;
		
		try {
			file =new BufferedReader(new FileReader(file_name));
			line= file.readLine();
			System.out.println("Reading file...");
			while ((line != null)&& (row<MAX_ROWS)) {
				token=new StringTokenizer(line," ");
				column=0;
				while (token.hasMoreTokens() &&column<MAX_COLUMNS) {
					map[row][column] = Integer.parseInt(token.nextToken());
					column++;
					
				}
				row++;
				line = file.readLine();
			}
			file.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR -> Map is not correct or not exist");
		}
	}
	public static void PrintAlgoTypes() {
		System.out.println("What algorithm do you want to use? (1 or 2)");
		System.out.println("1 - Best first");
		System.out.println("2 - A*");
		switch (key_input.nextInt()) {
		case 1:
			pending = new best_first();
			break;
		case 2:
			pending = new A_start();
			break;
		default: 
			System.out.println("ERROR -> Write a correct answer");
			PrintAlgoTypes();
			
	}
	}
	
	public static void PrintHeuTypes() {
		// TODO Auto-generated method stub
		System.out.println("Choose the heuristic type:");
		System.out.println("1 - Heuristic by position");
		System.out.println("2 - Heuristic by euclidian");
		System.out.println("3 - Heuristic by height");
		switch (key_input.nextInt()) {
		case 1:
			heuristic = new heuristic_1(final_position);
			break;
		case 2:
			heuristic = new heuristic_2(final_position);
			break;
		case 3:
			heuristic = new heuristic_3(final_position);
			break;
		default: 
			System.out.println("ERROR -> Write a correct answer");
			PrintHeuTypes();
	}
		key_input.close();
		
	}
	public static void SearchWalk(box actual_box, box final_box) {
		walk = null;
		boolean find = false;
		
		nodes = 0;
		pending.AddBox(actual_box);
		
		while (!find && pending.ThereAreBoxes()) {
			
			actual_box = pending.GetBox();
			pending.DeleteBox(actual_box); 
			if (actual_box.Same(final_box)) {
				find = true;
				System.out.println(actual_box);
				final_box.setCost(actual_box.getCost());
				walk = new Walk(actual_box.getWalk());
				walk.Add_Box(actual_box); 
				
			}
			else {
				System.out.println(actual_box);
				NextBox(actual_box, actual_box.getRow(), actual_box.getColumn() - 1);
				NextBox(actual_box, actual_box.getRow()- 1, actual_box.getColumn());
				NextBox(actual_box, actual_box.getRow(), actual_box.getColumn() + 1);
				NextBox(actual_box, actual_box.getRow()+ 1, actual_box.getColumn());
				tractates_boxes.add_box(actual_box); 
				nodes++;
			}
		}
		System.out.println("LLEGOWWWW");
	}
	
	public static void NextBox(box actual_box, int row, int column) {
		if ((row >= 0) && (row < MAX_ROWS) && (column >= 0) && (column < MAX_COLUMNS) && (map[row][column] != -1)) {
			box next_box = new box(map[row][column], row, column);
			
			if ((!tractates_boxes.box_content(next_box)) && (!pending.IsTheBox(next_box))) {
				next_box.CalculeWalk(actual_box.getWalk(),actual_box); 
				next_box.CalculateCost(actual_box);
				next_box.CalculateH(heuristic);
				pending.AddBox(next_box);
			}
		}
	}
	public static void PrintWalk() throws IOException {
		int row, column;
		PrintWriter pw = new PrintWriter(new FileWriter("walk.html"));
		pw.println("<style>TD{    padding: 25px;\r\n"
				+ "    background: #ffc8c8;\r\n"
				+ "    color: #00936a;\r\n"
				+ "    font-size: 36px;\r\n"
				+ "    border: 5px #000 solid;}</style>");
		pw.println("<TABLE>");
		System.out.print("\n");
		for (row = 0; row < MAX_ROWS; row++) {
			pw.println("<TR>");
			for (column = 0; column < MAX_COLUMNS; column++) {
				if (walk.Is_The_Box(new box(map[row][column], row, column)))	{
					System.out.print("*\t");
					pw.println("<TD style='background: #ffd400;'>"+map[row][column]+"\t</TD>");
				}
				else {
					
					if(map[row][column]==-1) {
						pw.println("<TD style='background: #ff0000;'>"+map[row][column]+"\t</TD>");
					}
					else {
						pw.println("<TD>"+map[row][column]+"\t</TD>");
					}
					System.out.print(map[row][column]+"\t");
				}
			}
			System.out.print("\n");
			pw.println("</TR>");
		}
		System.out.println("COST ---> "+final_position.getCost());
		System.out.println("STEPS ---> "+(walk.Size_walk()- 1));	
		System.out.println("EXPLORED NODES ---> "+nodes);
		pw.println("<h1>COST </h1><h2>"+final_position.getCost()+"</h2><br>");
		pw.println("<h1>STEPS </h1><h2>"+walk.Size_walk()+"</h2><br>");
		pw.println("<h1>EXPLORED NODES </h1><h2>"+nodes+"</h2><br>");
		File htmlFile = new File("walk.html");
		Desktop.getDesktop().browse(htmlFile.toURI());
        
      
        pw.println("</TABLE>");
        pw.close();
	}

	
	public static void main(String[] args) throws IOException {
		
		/*
		 * EXAMPLE 		1,2    8,5
		 */
		System.out.println("Welcome to Heuristic Search");
		ReadFile("map_custom.txt");
		StartEndPositions();
		
		tractates_boxes = new tractates();
		PrintAlgoTypes();
		PrintHeuTypes();
		
		SearchWalk(initial_position, final_position);
		
		PrintWalk();
		
		
		
		

	}



}
