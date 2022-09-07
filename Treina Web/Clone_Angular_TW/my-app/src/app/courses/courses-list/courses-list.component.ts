import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-courses-list',
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.less'],
})
export class CoursesListComponent implements OnInit {
  name = '';

  constructor(private activeRoute: ActivatedRoute,
              private router: Router) {}

  ngOnInit(): void {}
}
