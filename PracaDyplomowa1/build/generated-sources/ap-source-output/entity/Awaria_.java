package entity;

import entity.AwariaPK;
import entity.Maszyna;
import entity.Operator;
import entity.PracownikUr;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T23:11:21")
@StaticMetamodel(Awaria.class)
public class Awaria_ { 

    public static volatile SingularAttribute<Awaria, PracownikUr> pracownikUr1;
    public static volatile SingularAttribute<Awaria, Operator> operator1;
    public static volatile SingularAttribute<Awaria, String> czyPracuje;
    public static volatile SingularAttribute<Awaria, Maszyna> maszyna;
    public static volatile SingularAttribute<Awaria, AwariaPK> awariaPK;

}