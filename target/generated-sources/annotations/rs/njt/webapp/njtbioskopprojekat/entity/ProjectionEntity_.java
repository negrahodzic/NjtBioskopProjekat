package rs.njt.webapp.njtbioskopprojekat.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.njt.webapp.njtbioskopprojekat.entity.RoomEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-14T18:12:18")
@StaticMetamodel(ProjectionEntity.class)
public class ProjectionEntity_ { 

    public static volatile SingularAttribute<ProjectionEntity, Long> projectionId;
    public static volatile SingularAttribute<ProjectionEntity, String> edited;
    public static volatile SingularAttribute<ProjectionEntity, Date> dateTimeOfProjection;
    public static volatile SingularAttribute<ProjectionEntity, Long> movieId;
    public static volatile SingularAttribute<ProjectionEntity, String> technology;
    public static volatile SingularAttribute<ProjectionEntity, RoomEntity> room;

}