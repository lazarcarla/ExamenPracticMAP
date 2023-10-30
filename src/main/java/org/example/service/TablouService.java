package org.example.service;

import org.example.domain.Tablou;
import org.example.repository.Repository;
import org.example.utils.events.ChangeEventType;
import org.example.utils.events.UtilizatorEntityChangeEvent;
import org.example.utils.observer.Observable;
import org.example.utils.observer.Observer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TablouService implements Observable<UtilizatorEntityChangeEvent> {
    private Repository<Long, Tablou> repo;
    private List<Observer<UtilizatorEntityChangeEvent>> observers = new ArrayList<>();

    public TablouService(Repository<Long, Tablou> repo) {
        this.repo = repo;
    }

    public Tablou addUtilizator(Tablou user) {
        if(repo.save(user).isEmpty()){
            UtilizatorEntityChangeEvent event = new UtilizatorEntityChangeEvent(ChangeEventType.ADD, user);
            notifyObservers(event);
            return null;
        }
        return user;
    }

    public Tablou deleteUtilizator(Long id){
        Optional<Tablou> user=repo.delete(id);
        if (user.isPresent()) {
            notifyObservers(new UtilizatorEntityChangeEvent(ChangeEventType.DELETE, user.get()));
            return user.get();}
        return null;
    }

    public Iterable<Tablou> getAll(){
        return repo.findAll();
    }


    @Override
    public void addObserver(Observer<UtilizatorEntityChangeEvent> e) {

    }

    @Override
    public void removeObserver(Observer<UtilizatorEntityChangeEvent> e) {

    }

    @Override
    public void notifyObservers(UtilizatorEntityChangeEvent t) {

    }


//    public void cautareTablou(){
//        Iterable<Tablou> tablouri = getAll();
//        List<Tablou> tablou= StreamSupport.stream(tablouri.spliterator(), false).collect(Collectors.toList());
//        tablou.stream().filter(c-> Objects.equals(c.getTitlu(),"Nuferi Claude Monet")
//                .forEach(x->System.out.println(x));
//    }
    public void filtarareNatura(){
        Iterable<Tablou> tablouri = getAll();
        List<Tablou> tablou = StreamSupport.stream(tablouri.spliterator(), false).toList();
        tablou.stream().filter(c -> Objects.equals(c.getTematica(),"natura")).toList().forEach(System.out::println);
    }

    public void filtarareNatura8(){
        Iterable<Tablou> tablouri = getAll();
        List<Tablou> tablou = StreamSupport.stream(tablouri.spliterator(), false).toList();
        tablou.stream().filter(c -> Objects.equals(c.getTematica(),"natura") && c.getCelebritate() > 8).toList().forEach(System.out::println);
    }

    public void sortareDupaPictorSiTitlu(){
        Iterable<Tablou>tablouri = getAll();
        List<Tablou>tablou = StreamSupport.stream(tablouri.spliterator(),false).toList();
        tablou.stream().sorted(Comparator.comparing(Tablou::getPictor).thenComparing(Comparator.comparing(Tablou::getTitlu)))
                .map(a->a.getId() + " " + a.getPictor() +" "+  a.getTitlu() )
                .forEach(System.out::println);
    }

    public void sortareDupaTematica(){
        Iterable<Tablou> tablouri = getAll();
        List<Tablou>tablou = StreamSupport.stream(tablouri.spliterator(),false).toList();
        tablou.stream().sorted(Comparator.comparing(Tablou::getTematica)).toList()
                .stream().map(a->a.getTitlu()+" " + a.getPictor() + " " + a.getTematica())
                .forEach(System.out::println);
    }

    public void sortareDupaCelebritateDescrescator(){
        Iterable<Tablou> tablouri = getAll();
        List<Tablou>tablou = StreamSupport.stream(tablouri.spliterator(), false).toList();
        tablou.stream().sorted(Comparator.comparing(Tablou::getCelebritate).reversed()).toList()
                .stream().map(a->a.getId()+ " " + a.getCelebritate())
                .forEach(System.out::println);
    }


}
