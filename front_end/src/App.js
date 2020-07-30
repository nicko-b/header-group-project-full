import React, { Component } from 'react';
import Card from "react-bootstrap/Card";
import  "./App.css";
import ControlledCarousel from "./Components/Carousel.js";

class App extends Component {
    constructor(props) {
        super(props)
        this.state={
            flight: {}
        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/flight/1')
            .then(res => res.json())
            .then((data) => {
                this.setState({flight: data})
                console.log(this.state.flight)
            })
            .catch(console.log)
    }

    render() {
        return (
            <Card>
                <Card.Header as="h5" className="Description">  Departing from {this.state.flight.departurelocation}.  Flying to {this.state.flight.destinationlocation}. </Card.Header>
                <Card.Body>
                    <Card.Title>{this.state.flight.description}</Card.Title>
                        <div>
                            <ControlledCarousel />
                        </div>
                    <Card.Text>
                        {this.state.flight.departuredate}
                    </Card.Text>
                </Card.Body>
            </Card>
        )
    }
}
export default App;

//importing pictures correctly
//spaces within JSX not working