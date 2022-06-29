package Lee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Program {
    public static void main(String[] args) {
        var mg = new MapGenerator();
        System.out.println(
                new MapPrinter().MapColor(mg.getMap()));
        
        var Lee = new WaveAlgorithm(mg.getMap());
        Lee.Colorize(new Point(2, 2));

        System.out.println(
                new MapPrinter().rawData(mg.getMap()));

    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }
}

class MapGenerator {
    int[][] map;

    public MapGenerator() {
        int[][] map = {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        };
        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }

    public void setCat(Point pos) {
        map[pos.x][pos.y] = -2;
    }

    public void setExit(Point pos) {
        map[pos.x][pos.y] = -3;
    }
}

class MapPrinter {
    public MapPrinter() {

    }

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }

        return sb.toString();
    }

    public String MapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append("░");
                        break;
                    case -1:
                        sb.append("▓");
                        break;
                    case -2:
                        sb.append("C");
                        break;
                    case -3:
                        sb.append("E");
                        break;
                    default:
                        break;
                }
                ;
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

class WaveAlgorithm {
    int[][] map;

    public WaveAlgorithm(int[][] map) {
        this.map = map;
    }

    public void Colorize(Point startPoint) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 1;

        while (queue.size() != 0) {
            Point p = queue.remove();

            if (map[p.x - 1][p.y] == 0) {
                queue.add(new Point(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y - 1] == 0) {
                queue.add(new Point(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }
            if (map[p.x + 1][p.y] == 0) {
                queue.add(new Point(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y + 1] == 0) {
                queue.add(new Point(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }
        }
    }

    public ArrayList<Point> getRoad(Point exit) {
        ArrayList<Point> road = new ArrayList<>();
        ////
        return road;
    }
}