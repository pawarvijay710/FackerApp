package com.example.domain.common

import kotlinx.coroutines.Job

interface JobProvider : () -> Job
