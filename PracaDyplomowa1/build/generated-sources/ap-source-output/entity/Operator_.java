package entity;

import entity.Awaria;
import entity.Maszyna;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T23:11:22")
@StaticMetamodel(Operator.class)
public class Operator_ { 

    public static volatile SetAttribute<Operator, Awaria> awariaSet;
    public static volatile SingularAttribute<Operator, String> imie;
    public static volatile SingularAttribute<Operator, Maszyna> maszynaID;
    public static volatile SingularAttribute<Operator, String> nazwisko;
    public static volatile SingularAttribute<Operator, Integer> id;

}