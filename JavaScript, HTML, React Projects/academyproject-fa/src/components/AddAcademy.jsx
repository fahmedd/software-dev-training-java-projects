import {useState} from 'react'
import axios from 'axios'
import {useNavigate} from 'react-router-dom'
import '../styles/AddAcademy.css'

const AddAcadmey = () => {

    const [name, setName] = useState('')
    const [address, setAddress] = useState('')
    const [message, setMessage] = useState(false)
    const navigate = useNavigate()
    const api = 'http://localhost:8088/api/v1/academy/'


    const submitNewAcademy = (event)=>{
        if((name!=='') && (address!=='')){
        axios.post(api,
        {name : name,
        address : address,})
        .then((response)=> {
            navigate('/Academies/')
        })
        .catch((error) => {
                console.error('An academy already exists in that location')
                setMessage(true);
        })
            
             event.preventDefault()
        }
    }
    

    return(
        <div className="Academy-card">
        <div className="card-body">
            <form className='AcademyForm' onSubmit={submitNewAcademy}>
            <div className="form-group">
                <label >Location/Name</label>
                <input type="text" className="form-control" id="name" aria-describedby="nameHelp" placeholder="Enter Location" value={name} onChange={(event) => setName(event.target.value)}/>
            </div>
            <div class="form-group">
                <label> Address</label>
                <input type="text" className="form-control" id="Address" placeholder="Enter Address" value={address} onChange={(event) => setAddress(event.target.value)}/>
            </div>
            <button type="submit" className="btn btn-secondary">Create Academy</button>
            </form>
            {message && <p className="text-danger">An academy already exists in that location!</p>}
        </div>
        </div>
    )
}

export default AddAcadmey