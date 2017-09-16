package logic;

public class Grid {
    
    private State[][] game;
    private int width;
    private int height;
    private int organismSize;
    public Grid(int width, int height, int organismSize){
        this.organismSize = organismSize;
        this.height = height;
        this.width = width;
        game = new State[height][width];
        for(int i=0; i < height; i++){
            for(int j=0; j < width; j++){
                game[i][j] = State.DEAD;
            }
        }
    }
    public Grid(boolean start[][], int width, int height){
        this.height = height;
        this.width = width;
        game = new State[height][width];
        for(int i=0; i < height; i++){
            for(int j=0; j < width; j++){
                if(start[i][j]){
                    game[i][j] = State.ALIVE;
                }else{
                    game[i][j] = State.DEAD;
                }
            }
        }
    }
    /*
     * Checks if some tile at (x,y) is going to be alive or dead,
     * checking that positions neighbors with Conway's game of life rules
     * */
    public State check(int x, int y){
        int count_alive = 0;
        int right_neighbor = (x + 1) % width;
        int left_neighbor = (x - 1) < 0 ? width - 1 : (x - 1) % width;
        int upp_neighbor = (y - 1) < 0 ? height-1 : (y - 1) % height;
        int down_neighbor = (y + 1) % width;
        //check right/left neighbor
        if(game[y][right_neighbor] == State.ALIVE){
            count_alive++;
        }
        if(game[y][left_neighbor] == State.ALIVE){
            count_alive++;
        }
        //check up/down neighbor
        if(game[upp_neighbor][x] == State.ALIVE){
            count_alive++;
        }
        if(game[down_neighbor][x] == State.ALIVE){
            count_alive++;
        }
        //check diagonal neighbor
        if(game[down_neighbor][right_neighbor] == State.ALIVE){
            count_alive++;
        }
        if(game[down_neighbor][left_neighbor] == State.ALIVE){
            count_alive++;
        }
        if(game[upp_neighbor][right_neighbor] == State.ALIVE){
            count_alive++;
        }
        if(game[upp_neighbor][left_neighbor] == State.ALIVE){
            count_alive++;
        }
        // evaluate
        if(game[y][x] == State.ALIVE){
            if(count_alive != 3 && count_alive != 2){
                return State.DEAD;
            }else{
                return State.ALIVE;
            }
        }else{
            if(count_alive == 3){
                return State.ALIVE;
            }else{
                return State.DEAD;
            }
        }
    }
    public State getStateAt(int x, int y){
        return game[y][x];
    }
    public void setStateAt(int x, int y, State state){
        game[y][x] = state;
    }
    public int getOrganismSize() {
        return organismSize;
    }
}
