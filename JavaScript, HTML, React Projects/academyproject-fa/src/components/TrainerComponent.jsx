const TrainerComponent= (props) => {

    const {name, academy, courses} = props.trainer

    return(
        <div className="card">
        <div className="card-body">
        <h5 className="card-title"> Name: {name} </h5><br/>
        <h6 className="card-subtitle mb-2 text-muted">Academy: {academy.name}</h6>
        <h6> Courses: </h6> {courses.map(course => <span> {course.name} <br/> </span>  )}
        <button type="button" className="btn btn-secondary">View </button>
        </div>
        </div>
                
    )
}

export default TrainerComponent