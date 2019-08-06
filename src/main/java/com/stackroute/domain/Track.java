package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//Entity annotated class will have the ability to represent objects in the database
//@Entity
@Document(collection = "tracks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Track {

//    public Track() {
//
//    }
//
//    public Track(int id, String trackName, String comments) {
//        this.id = id;
//        this.trackName = trackName;
//        this.comments = comments;
//    }

    //Id annotation make id variable as Primary key
    @Id
    private int id;
    private String trackName;
    private String comments;
//

}

  //  public String saveTrack(Object any) {


//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return false;
//    }
//
//    @Override
//    public Iterator<Track> iterator() {
//        return null;
//    }
//
//    @Override
//    public Object[] toArray() {
//        return new Object[0];
//    }
//
//    @Override
//    public <T> T[] toArray(T[] ts) {
//        return null;
//    }
//
//    @Override
//    public boolean add(Track track) {
//        return false;
//    }
//
//    @Override
//    public boolean remove(Object o) {
//        return false;
//    }
//
//    @Override
//    public boolean containsAll(Collection<?> collection) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(Collection<? extends Track> collection) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(int i, Collection<? extends Track> collection) {
//        return false;
//    }
//
//    @Override
//    public boolean removeAll(Collection<?> collection) {
//        return false;
//    }
//
//    @Override
//    public boolean retainAll(Collection<?> collection) {
//        return false;
//    }
//
//    @Override
//    public void clear() {
//
//    }
//
//    @Override
//    public Track get(int i) {
//        return null;
//    }
//
//    @Override
//    public Track set(int i, Track track) {
//        return null;
//    }
//
//    @Override
//    public void add(int i, Track track) {
//
//    }
//
//    @Override
//    public Track remove(int i) {
//        return null;
//    }
//
//    @Override
//    public int indexOf(Object o) {
//        return 0;
//    }
//
//    @Override
//    public int lastIndexOf(Object o) {
//        return 0;
//    }
//
//    @Override
//    public ListIterator<Track> listIterator() {
//        return null;
//    }
//
//    @Override
//    public ListIterator<Track> listIterator(int i) {
//        return null;
//    }
//
//    @Override
//    public List<Track> subList(int i, int i1) {
//        return null;
//    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
////    }
//    }
////



//}