package Week3;
import java.util.*;

public class CoveringSegments {

    //private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        //first manipulate with the segments....
        //safe choice is if we choose the rightmost point from the algorithm...
        //take the first segment and check whether it overlaps with any of all the other segments
        //if it does choose the rightmost point of the first segment and then delete the other segments...
        //now we have a subproblem to solve i.e., the segments that are left....
        //
        //first let's sort them
/*
        for(int i = 0; i < segments.length; i++){
            for(int j = 0; j < segments.length - 1; j++){
                if(segments[j].end > segments[j + 1].end){
                    //swap starts but also ends...
                    int tempS = segments[j].start;
                    int tempE = segments[j].end;
                    segments[j].start = segments[j + 1].start;
                    segments[j + 1].start = tempS;

                    segments[j].end = segments[j + 1].end;
                    segments[j + 1].end = tempE;
                }
            }
        }

        List<Segment> segmentsList = new ArrayList<Segment>();
        for(int i = 0; i < segments.length; i++){
            segmentsList.add(segments[i]);
        }
        int counter = 0;
        //List<Segment> result = new ArrayList<Segment>();
        int i = 0;
        while(i < segments.length){
            result.add(segments[i]);
            for(int j = i + 1; j < segments.length; j++){
                //if the one in results[i] overlaps with the next we keep the result and continue....
                //if it's not we just leave it in the result
                if(((result.get(i).start >= segments[j].start) && (result.get(i).start <= segmentsList.get(j).end))
                        ||((segmentsList.get(i).end >= segmentsList.get(j).start) && (segmentsList.get(i).end <= segmentsList.get(j).end))){
                    System.out.println("Overlap");
                    segmentsList.remove(j);
                    result.add(segmentsList.get(i).end);
                }

            }
        }

        int[] points = new int[2 * segments.length];
        for(int l = 0; l < segments.length; l++) {
            points[2 * l] = segments[l].start;
            points[2 * l + 1] = segments[l].end;
        }





        /*
        while(segmentsList.get(i) != null){
            result.add(segmentsList.get(i));
            while(segmentsList.get(j) != null){

                if(((segmentsList.get(i).start >= segmentsList.get(j).start) && (segmentsList.get(i).start <= segmentsList.get(j).end))
                        ||((segmentsList.get(i).end >= segmentsList.get(j).start) && (segmentsList.get(i).end <= segmentsList.get(j).end))){
                    System.out.println("Overlap");
                    segmentsList.remove(j);
                    result.add(segmentsList.get(i).end);
                }
            }
            i++;
        }


        return points;*/

  //  }


    private static int[] optimalPointsFast(Segment[] segments) {
        //write your code here

        //sorting according to their endpoint...
        for(int i = 0; i < segments.length; i++){
            for(int j = 0; j < segments.length - 1; j++){
                if(segments[j].end > segments[j + 1].end){
                    //swap starts but also ends...
                    int tempS = segments[j].start;
                    int tempE = segments[j].end;
                    segments[j].start = segments[j + 1].start;
                    segments[j + 1].start = tempS;

                    segments[j].end = segments[j + 1].end;
                    segments[j + 1].end = tempE;
                }
            }
        }

        //for loop in segments
        //find that in theList of segments...
        //remove it...

        List<Segment> segmentsList = new ArrayList<Segment>();
        for(int i = 0; i < segments.length; i++){
            segmentsList.add(segments[i]);
        }

        List<Segment> result = new ArrayList<Segment>();

       int counter = 0;
        for(int i = 0; i < segments.length; i++){
            for(int j = i + 1; j < segments.length; j++){
                if(((segments[i].start >= segments[j].start) && (segments[i].start <= segments[i].end))
                || ((segments[i].end >= segments[j].start) && (segments[i].end <= segments[j].end))){
                    //overlapping...
                    //remove it from the segmentsList...
                    //if it is in the segmentsList remove it...
                    if(segmentsList.contains(segments[j])){
                        segmentsList.remove(segments[j]);
                        counter =1;
                        //System.out.println("Removing: " + segments[j].start + " " + segments[j].end);
                    }
                    //System.out.println("Overlapping");
                }



            }
            i += counter;
            counter = 0;
        }

        for(int i = 0; i < segmentsList.size(); i++){
            //System.out.print(segmentsList.get(i).end + " ");
        }
        //System.out.println();

        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }
        //System.out.println(segmentsList.size());
        int[] points2 = new int[segmentsList.size()];
        for (int i = 0; i < segmentsList.size(); i++) {
            points2[i] = segmentsList.get(i).end;
        }
        return points2;
    }
    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPointsFast(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

